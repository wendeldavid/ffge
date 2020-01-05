<template>
    <div class="sign-up">
        <p>Crie sua conta</p>
        <input type="text" v-model="displayName" placeholder="Nome"><br>
        <input type="text" v-model="email" placeholder="Email"><br>
        <input type="password" v-model="password" placeholder="Senha"><br>
        <button @click="signUp">Cadastre-se</button>
        <span><router-link to="/login">ou volte para o login</router-link></span>
    </div>
</template>

<script>

import router from '../router';

import firebase from 'firebase';

export default {
    name: 'signUp',
    data() {
        return {
            displayName: '',
            email: '',
            password: ''
        }
    },
    methods: {
        signUp: function() {
            let displayName = this.displayName;

            if (!displayName) {
                alert('Informe seu nome de exibição na ofensa');
                return;
            }
            if (!this.email) {
                alert('Informe seu email de cadastro');
                return;
            }
            if (!this.password) {
                alert('Informe sua senha');
                return;
            }

            firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
                function(user) {
                    // alert('Your account has been created!' + user);
                    if (user) {
                        user.user.updateProfile({
                            displayName: displayName
                        });

                        router.replace('portal');
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
    min-width: 300px;
}

button {
    margin-top: 10px;
    width: 10%;
    cursor: pointer;
    min-width: 150px;
}

span {
    display: block;
    margin-top: 20px;
    font-size: 11px;
}

</style>