<template>
    <div>
        <span>{{message}}</span>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                message: "Hello Vue",
            }
        },
        beforeMount() {
          console.log("Hello Vue");
        },
    };
</script>

<style lang="scss" scoped>

   @import "./style/hello";

</style>