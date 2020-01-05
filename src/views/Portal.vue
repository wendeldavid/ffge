<template>
<div class="status">
      <p>
        <label>Estamos trabalhando há</label>
        <label class="number">{{portal.days}}</label>
        <label> dias(s) sem ser grosso e escroto.</label>
      </p>
      <p>
        <label>Nosso recorde é de</label>
        <label class="number">{{portal.record}}</label>
        <label>dias. Colabore para melhorar este índice.</label>
      </p>

      <b-list-group>
        <b-list-group-item href="#" class="flex-column align-items-start" v-bind:class="{ 'd-none': grosseria.hide }" v-for="grosseria in portal.grosserias" v-bind:key="grosseria.id">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">Foi {{grosseria.acao}} com <b>{{grosseria.vitima}}</b></h5>
            <small>{{grosseria.data.date.day}}/{{grosseria.data.date.month + 1}}/{{grosseria.data.date.year}} - {{grosseria.data.time.hour}}:{{grosseria.data.time.minute}}</small>
          </div>

          <blockquote class="quote">
            {{grosseria.descricao}}
          </blockquote>

          <small v-bind:class="{ 'd-none': !grosseria.replica }"><b>Réplica:</b> {{grosseria.replica}}</small>
        </b-list-group-item>
      </b-list-group>
  </div>
</template>

<script>

import Vue from 'vue';
import firebase from 'firebase';
import VueMoment from 'vue-moment';
import moment from 'moment-timezone';
 
Vue.use(VueMoment, {
    moment
});

moment.locale('pt-BR');

var portal = {
  grosserias: [],
  days: 0,
  record: 0
};

export default {
    name: 'portal',
    data() {
      return {
        portal: portal
      };
    },
    mounted() {
       let database = firebase.database();

        let data = database.ref().child('/grosserias/');
        
        data.once('value').then(function(snapshot) {
            var grosserias = snapshot.val();
            grosserias = Object.values(grosserias).reverse();
            
            portal.grosserias = grosserias;

            let now = moment(moment.now());
            let last = grosserias[0];

            let lastGrosseria = moment([last.data.date.year, last.data.date.month, last.data.date.day]);
            portal.days = now.diff(lastGrosseria, 'days');

            for (var i = 0; i < grosserias.length; i++) {
              if (i === grosserias.length - 1 || 
                !grosserias[0].data     || !grosserias[0].data.date ||
                !grosserias[0 + 1].data || !grosserias[0 + 1].data.date) {
                break;
              }

              let grosseria = grosserias[i];
              let a = moment([grosseria.data.date.year, grosseria.data.date.month, grosseria.data.date.day]);

              let proximaProsseria = grosserias[i + 1];
              let b = moment([proximaProsseria.data.date.year, proximaProsseria.data.date.month, proximaProsseria.data.date.day]);

              let currentDiff = a.diff(b, 'days');

              // alert(currentDiff);

              if (currentDiff > portal.record) { 
                portal.record = currentDiff;
              }

              if (portal.record < portal.days) {
                portal.record = portal.days;
              }
            }

        });

        

        
    }
}
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

.quote {
  position: relative;
  font-family: 'Sanchez', serif;
  font-size: 2em;
  line-height: 1.5em;
  padding: 0 10 0 10;
  margin: 0 10 0 10;
}
.quote:before {
    content: '\201C';
    position: absolute;
    top: 0.25em;
    left: -0.10em;
    font-size: 3em;
    z-index: -1;
  }
.quote:after {
    content: '\201D';
    position: absolute;
    bottom: 0em;
    right: -0.10em;
    font-size: 3em;
    font-style: italic;
    z-index: -1;
  }

.portal.logo {
  padding: 50px;
}

.portal .status p {
  font-weight: bold;
  font-size: 20px;
}

.portal .number {
  color: red;
}

.portal .number:before {
  content: "\00a0";
}

.portal .number:after {
  content: "\00a0";
}

</style>