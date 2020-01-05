<template>
    <form>
        <div class="form-group">
            <label>Selecione qual tipo de ofensa você sofreu</label>
            <div class="form-check">
                <p>
                    <input id="cbGrosso" class="form-check-input" type="checkbox" aria-label="Checkbox for following text input" v-model="selectionGrosso">
                    <label lass="form-check-label" for="cbGrosso">Grosso</label>
                </p>
                <p>
                    <input id="cbEscroto" class="form-check-input" type="checkbox" aria-label="Checkbox for following text input" v-model="selectionEscroto">
                    <label lass="form-check-label" for="cbEscroto">Escroto</label>
                </p>
                </div>
                
            <label>Descreva como foi a ofensa</label>
            <p><textarea v-model="description"></textarea></p>
            <p><button @click="login">Cadastrar ofensa</button></p>
        </div>
    </form>
</template>

<script>

import Vue from 'vue';
import firebase from 'firebase';
import VueMoment from 'vue-moment';
import moment from 'moment-timezone';

Vue.use(VueMoment, {
    moment
});

export default {
    name: 'register',
    data() {
        return {
            description: '',
            selectionGrosso: false,
            selectionEscroto: false
        };
    },
    methods: {
        login: function() {
            let database = firebase.database();

            let data = database.ref().child('/grosserias/');

            let newOrderKey = data.push();

            //montar acao
            let acao = '';
            if (this.selectionGrosso && this.selectionEscroto) {
                acao = acao + 'Grosseiro e Escroto';
            } else if (this.selectionGrosso) {
                acao = 'Grosseriro';
            } else if (this.selectionEscroto) {
                acao = 'Escroto';
            } else {
                alert('Selecionar ao menos um tipo de ofensa');
                return;
            }

            //descrição da ofensa
            if (!this.description) {
                alert('Descrever qual a ofensa você foi vítima');
                return;
            }

            //vitima
            let currentUser = firebase.auth().currentUser;

            //data e hora
            let now = moment();

            let newEntry = {
                id: newOrderKey.key,
                acao: acao,
                descricao: this.description,
                data: {
                    date: {
                        day: now.dayOfYear(),
                        month: now.month(),
                        year: now.year()
                    },
                    time: {
                        hour: now.hour(),
                        minute: now.minute(),
                        second: now.second()
                    }
                },
                hide: false,
                vitima: currentUser.displayName
            }

            newOrderKey.set(newEntry);

            this.$router.replace('portal');
        }
    }
}
</script>

<style scoped>

textarea {
    width: 40em;
    height: 8em;
    margin: 10px 0;
    padding: 15px;
}

button {
    margin-top: 20px;
    /* width: 10%; */
    cursor: pointer;
}
</style>