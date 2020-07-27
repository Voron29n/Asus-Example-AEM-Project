<template>
    <div>
        {{modelData.linkTo}}
    </div>
</template>

<script>
export default {
    props: {
        modelProp: {
            type: String,
            required: true
        }
    },
    computed: {
        modelData() {
            return JSON.parse(this.$props.modelProp);
        }
    }
};
</script>

<style lang="scss" scoped>
@import "./style/default";
</style>
