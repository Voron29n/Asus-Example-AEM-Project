<template>
    <div class="cmp_article_images-title">
        <h3>{{titleData.imageTextTitle}}</h3>
    </div>
</template>

<script>

export default {
    props: {
        titleData: Object,
    },
    
};
</script>

<style lang="scss" scoped>
@import "./title_default";
@import "./title_media";
</style>