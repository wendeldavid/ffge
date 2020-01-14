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
    
    <div class="easteregg" v-bind:class="{ 'd-none': !portal.eastereggfound }">
      
      <div
        id="ffgePlayer"
        class="ffge-player">
        <audio controls>
          <!-- <source
            src="media/falafinacast.wav"
            type="audio/wav"> -->
          <source src="https://firebasestorage.googleapis.com/v0/b/ffge-portal.appspot.com/o/audio%2Ffalafinacast.mp3?alt=media&amp;token=5ca8cb27-79f3-43ff-ad77-c373b034d3ac" type="audio/mp3">
          <p>Use um browser decente para ouvir o falafinacast!</p>
        </audio>
      </div>

      <img class="ffge-image" id="ffgeImage">

    </div>


    <router-view/>

    

  </div>
</template>

<script>
import firebase from 'firebase';

var ff = [ 70, 70 ];
var ffQueue = [];
var portal = {
  eastereggfound: false
};
document.onkeydown = ffQueueKey;

function ffQueueKey(e) {
    var event = window.event ? window.event : e;

    ffQueue.push(event.keyCode);
    if (ffQueue.length > 2) {
        ffQueue.shift();
    }

    if (ffQueue.length == 2) {
        var ffOK = true;
        for (var i = 0; i < ff.length; i++) {
            if (ff[i] !== ffQueue[i]) {
                ffOK = false;
                break;
            }
        }
        if (ffOK) {
            portal.eastereggfound = true;

            ffQueue = []

            let storage = firebase.storage();

            var bucket = storage.refFromURL('gs://ffge-portal.appspot.com/');

            var imgFolder = bucket.child('img');

            imgFolder.listAll().then(function(res) {
              var allFiles = res.items;
              var imgIndex = Math.floor(Math.random() * allFiles.length);

              allFiles[imgIndex].getDownloadURL().then(function(url) {
                var image = document.getElementById('ffgeImage');
                image.src = url;
              });
            });

            
            var player = document.getElementById('ffgePlayer');
            player.style.display = '';
        }
    }
}

export default {
    name: 'portal',
    data() {
      return {
        portal: portal
      };
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



</style>
