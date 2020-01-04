<template>

  <div id="app" class="portal">

    <div id="nav">
      <router-link to='/portal'>Portal</router-link>
      | <router-link to='/register'>Registrar Ofensa</router-link>
      | <router-link to='/login'>Login</router-link>
      | <router-link to="/logout">Logout</router-link>
      | <router-link to="/about">About</router-link>
    </div>
    
    <img class="logo" alt="FFGE" src="./assets/cipa.png">

    <router-view/>
  </div>
</template>

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

</style>
