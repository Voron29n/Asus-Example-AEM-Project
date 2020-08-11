<template>
    <div class="cmp_article_text-description" >
        <span v-html="descriptionData.textDescription"></span> 
    </div>
</template>

<script>

export default {
    props: {
        descriptionData: Object,
    },
};
</script>

<style lang="scss">
@import "./description_default";
@import "./description_media";
</style>