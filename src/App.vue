<template>

  <div id="app" class="portal">

    <div id="nav">
      <router-link to='/portal'>Portal</router-link>
      | <router-link to='/login'>Login</router-link>
      | <router-link to="/about">About</router-link>      
    </div>
    
    <img class="logo" alt="FFGE" src="./assets/cipa.png">

    <div class="status">
      
      <p>
        <label>Estamos trabalhando há</label>
        <label class="number">{{portal.days}}</label>
        <label>dia(s) sem ser grosso e escroto.</label>
      </p>
      <p>
        <label>Nosso recorde é de</label>
        <label class="number">{{portal.record}}</label>
        <label>dias. Colabore para melhorar este índice.</label>
      </p>

    </div>

    <router-view/>
  </div>
</template>

<script>
export default {
      name: 'portal',
    data() {
      return {
        portal: {
          days: 0,
          record: 0
        }
      }
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
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
