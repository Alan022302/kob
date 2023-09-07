<template>
    <ContentField v-if="!$store.state.user.pulling_info">
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="login">
                    <div class="mb-3">
                        <label for="username" class="form-label">用户名</label>
                        <input v-model="username" type="text" class="form-control" id="username" placeholder="请输入用户名">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">密码</label>
                        <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
                    </div>
                    <div class="error-message">{{ message }}</div>
                    <button type="submit" class="btn btn-primary">提交</button>
                </form>
                <hr class="divider">
                <p class="divider-text">其他方式登录</p>
                <div style="text-align: center; margin-top: 20px; cursor: pointer;" @click="qq_login">
                    <img height="50" src="https://wiki.connect.qq.com/wp-content/uploads/2013/10/03_qq_symbol-1-768x921.png" alt="">
                    <p class="qq-text">QQ账号登录</p>
                </div>
            </div>
        </div>
    </ContentField>
</template>

<script>
import ContentField from '../../../components/ContentField.vue'
import { useStore } from 'vuex'
import { ref } from 'vue'
import router from '../../../router/index'
import $ from 'jquery'

export default {
    components: {
        ContentField
    },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let message = ref('');

        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getinfo", {
                success() {
                    router.push({name: "home"});
                    store.commit("updatePullingInfo", false);
                },
                error() {
                    store.commit("updatePullingInfo", false);
                }
            })
        } else {
            store.commit("updatePullingInfo", false);
        }

        const login = () => {
            message.value = "";
            store.dispatch("login", {
                username: username.value,
                password: password.value,
                success() {
                    store.dispatch("getinfo", {
                        success() {
                            router.push({ name: 'home' });
                            console.log(store.state.user);
                        }
                    })
                },
                error() {
                    message.value = "用户名或密码错误";
                }
            })
        }

        const qq_login = () => {
            $.ajax({
                url: "https://app5878.acapp.acwing.com.cn/api/user/account/qq/apply_code/",
                type: "GET",
                success: resp => {
                    if (resp.result === "success") {
                        window.location.replace(resp.apply_code_url);
                    }
                }
            })
        }


        return {
            username,
            password,
            message,
            login,
            qq_login,
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}
div.error-message {
    color: red;
}
hr.divider {
    margin-top: 50px;
    margin-bottom: 5px;
}
p.divider-text {
    margin-top: 0px;
    margin-bottom: 20px;
    text-align: center;
    font-size: 15px;
    color: gray;
}
p.qq-text {
    margin-top: 0px;
    font-size: 15px;
    font-weight: 600;
}
</style>
