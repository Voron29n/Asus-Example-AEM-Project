<template>
    <div id="article_image-component-vue">
        <VueTitle :title-data="titleData"></VueTitle>
        <VueImages :images-data="imagesData"></VueImages>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ArticleImages" */ "./v-components/title/Title"
            ),
        VueImages: () =>
            import(
                /* webpackChunkName: "ArticleImages" */ "./v-components/images/Images"
            ),
    },
    props: {
        imagesTitle: {
            type: String,
            required: false,
        },
        images: {
            type: String,
            required: false,
        },
    },
    computed: {
        titleData() {
            return {
                imagesTitle: this.$props.imagesTitle,
            };
        },
        imagesData() {
            return {
                images: JSON.parse(this.$props.images),
            };
        },
    },
};
</script>

<style lang="scss" scoped>
@import "./v-style/article_images_default";
@import "./v-style/article_images_media";
</style>