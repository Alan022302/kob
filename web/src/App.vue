<template>
  <NavBar />
  <router-view/>
</template>

<script>
  import NavBar from './components/NavBar.vue'
  import "bootstrap/dist/css/bootstrap.min.css"
  import "bootstrap/dist/js/bootstrap"
  //import $ from "jquery"

  export default {
    components: {
      NavBar
    },
    setup() {
      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/token/",
      //   type: "post",
      //   data: {
      //     username: 'alan',
      //     password: 'palan',
      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // })

      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/info/",
      //   type: "get",
      //   headers: {
      //     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmMTJhMTk1OGIzNWQ0ODc1YjA1MzFiYTQ3ZjViNDU3YSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY5MTY3MTY5NiwiZXhwIjoxNjkyODgxMjk2fQ.wovBjEQiHIe-pVsJ8xCUkKbe4I1cLlCEk8EvT8YLq6M"
      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // })

      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/register/",
      //   type: "post",
      //   data: {
      //     username: 'alan23',
      //     password: 'palan23',
      //     confirmedPassword: "palan23",
      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // })
    }
  }
</script>

<style>
  body {
    background-image: url("./assets/images/background.png");
    background-size: cover;
  }
</style>
