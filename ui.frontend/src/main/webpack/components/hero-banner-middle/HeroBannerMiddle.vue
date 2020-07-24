<template>
    <div>
       {{source}} Hello
    </div>
</template>

<script>
export default {
    props: {
        source: {
            type: Object,
            required: true
        },
        // linkTo: {
        //     type: Boolean,
        //     required: true
        // },
        // linkUrlTarget: {
        //     type: String,
        //     required: true
        // }
    },
};
</script>

<style lang="scss" scoped>
@import "./style/default";
</style>
