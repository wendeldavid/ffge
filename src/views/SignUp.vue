<template>
    <div class="sign-up">
        <p>Crie sua conta</p>
        <input type="text" v-model="email" placeholder="Email"><br>
        <input type="password" v-model="password" placeholder="Senha"><br>
        <button @click="signUp">Cadastre-se</button>
        <span><router-link to="/login">ou volte para o login</router-link></span>
    </div>
</template>

<script>

import firebase from 'firebase';

export default {
    name: 'signUp',
    data() {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        signUp: function() {
            firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
                function(user) {
                    // alert('Your account has been created!' + user);
                    if (user) {
                        this.$router.replace('portal');
                    }
                },
                function(err) {
                    alert('Oops: ' + err.message);
                }
            );
        }
    }
}
</script>

<style scoped>

.signUp {
    margin-top: 40px;
}

input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
}

button {
    margin-top: 10px;
    width: 10%;
    cursor: pointer;
}

span {
    display: block;
    margin-top: 20px;
    font-size: 11px;
}

</style>