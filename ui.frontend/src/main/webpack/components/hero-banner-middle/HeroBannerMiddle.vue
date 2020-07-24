<template>
    <div>
        Hello
    </div>
</template>

<script>
export default {
    data(){
        return {
            modelData: {}
        }
    },
    props: {
        modelProp: {
            type: String,
            required: true
        },
    },
    beforeMount() {
        this.$data.modelData = JSON.parse(this.$props.modelProp);
    }
};
</script>

<style lang="scss" scoped>
@import "./style/default";
</style>
