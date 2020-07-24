<template>
    <div>
        Hello
    </div>
</template>

<script>
export default {
    props: {
        source: {
            type: String,
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
