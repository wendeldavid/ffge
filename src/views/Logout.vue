<template>
    <div></div>
</template>

<script>

import firebase from 'firebase';



export default {
    name: 'logout',
    data() {
        firebase.auth().signOut().then(() => {
            this.$router.replace('portal')
        });

        return {};
    }
}
</script>