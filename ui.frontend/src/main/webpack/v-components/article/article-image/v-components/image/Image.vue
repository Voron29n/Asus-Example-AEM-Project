<template>
    <div class="cmp_article_image">
        <br>
            <img :src="imageData.fileReference" alt=""/>
        <br>
    </div>
</template>

<script>

export default {
    props: {
        imageData: Object,
    },
};

</script>

<style lang="scss" scoped>
@import "./image_default";
@import "./image_media";
</style>