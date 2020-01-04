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