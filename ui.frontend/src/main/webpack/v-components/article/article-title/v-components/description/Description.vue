<template>
    <div class="cmp_article_title-description" >
        <span v-html="descriptionData.titleDescription"></span> 
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