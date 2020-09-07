<template>
    <div id="article_image-component-vue">
        <VueImage :image-data="imageData"></VueImage>
    </div>
</template>

<script>
export default {
    name: "article_image-data",
    components: {
        "article_image-data": () => import( /* webpackChunkName: "ArticleImage" */ './ArticleImage.vue').then(m => m.default),
        VueImage: () =>
            import(
                /* webpackChunkName: "ArticleImage" */ "./v-components/image/Image"
            ),
    },
    props: {
        fileReference: {
            type: String,
            required: false,
        },
    },
    computed: {
        imageData() {
            return {
                fileReference: this.$props.fileReference,
            };
        },
    },
};
</script>

<style lang="scss" scoped>
@import "./v-style/article_image_default";
@import "./v-style/article_image_media";
</style>