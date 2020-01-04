<template>
    <div class="login">
        <h3>Login</h3>
        <input type="text" v-model="email" placeholder="Email"><br>
        <input type="password" v-model="password" placeholder="Password"><br>
        <button @click="login">Entrar</button>
        <p>Você não tem um conta ainda? <router-link to='/sign-up'>Então crie uma</router-link></p>
    </div>
</template>

<script>

import router from '../router';
import firebase from 'firebase';

export default {
    name: 'login',
    data() {
        return {
            email: '',
            password: ''
        };
    },
    methods: {
        login: function() {
            firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
                function(user) {
                    // alert('Login successful' + user);
                    if (user) {
                        // this.$router.replace('portal');
                        router.replace('portal');
                    }
                },
                function(err) {
                    alert('Oops! ' + err.message);
                }
            );
            
        }
    }
}
</script>

<style scoped>

.login {
    margin-top: 40px;
}

input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
}

button {
    margin-top: 20px;
    width: 10%;
    cursor: pointer;
}

p {
    margin-top: 40px;
    font-size: 13px;
}

p a {
    text-decoration: underline;
    cursor: pointer;
}

</style>