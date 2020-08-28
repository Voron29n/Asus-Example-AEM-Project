<template>
    <div class="cmp_customized-title">
        <p></p>
        <span v-html="titleData.textTitle"></span> 
    </div>
</template>

<script>

export default {
    props: {
        titleData: Object,
    },
    
};
</script>

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>