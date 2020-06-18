import Vue from 'vue';
import firebase from 'firebase';
import App from './App.vue';
import router from './router';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

Vue.use(BootstrapVue);

Vue.config.productionTip = false;

let app = '';

const config = {
  apiKey: 'AIzaSyBofpG_MS_xyQxC4aem8u0Bi8UPCkZdYoA',
  authDomain: 'ffge-portal.firebaseapp.com',
  databaseURL: 'https://ffge-portal.firebaseio.com',
  projectId: 'ffge-portal',
  storageBucket: 'ffge-portal.appspot.com',
  messagingSenderId: '895779158267'
}

firebase.initializeApp(config);

firebase.auth().onAuthStateChanged(() => {
  if (!app) {
    app = new Vue({
      router,
      render: h => h(App)
    }).$mount('#app');
  }
});
