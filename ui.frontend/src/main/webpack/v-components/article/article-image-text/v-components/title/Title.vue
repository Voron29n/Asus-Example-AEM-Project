<template>
    <div class="cmp_article_image_text-title">
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

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>