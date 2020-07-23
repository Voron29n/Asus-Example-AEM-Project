<template>
    <div>
        <span>{{message}}</span>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                message: "ХУЕТАsss",
            }
        },
        beforeMount() {
          console.log("ТУТУТУТУТУТ");
        },
    };
</script>

<style lang="scss" scoped>

   @import "./style/hello";

</style>