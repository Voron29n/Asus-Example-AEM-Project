<template>
    <div id="article_image-text-component-vue">
        <VueTitle :title-data="titleData"></VueTitle>
        <div class="cmp_article_image_text-block">
            <VueImage :image-data="imageData"></VueImage>
            <VueDescription :description-data="descriptionData"></VueDescription>
        </div>
    </div>
</template>

<script>
export default {
    components: {
        VueTitle: () =>
            import(
                /* webpackChunkName: "ArticleImageText" */ "./v-components/title/Title"
            ),
        VueImage: () =>
            import(
                /* webpackChunkName: "ArticleImageText" */ "./v-components/image/Image"
            ),
        VueDescription: () =>
            import(
                /* webpackChunkName: "ArticleImageText" */ "./v-components/description/Description"
            ),
    },
    props: {
        imageTextTitle: {
            type: String,
            required: false,
        },
        imageTextDescription: {
            type: String,
            required: false,
        },
        fileReference: {
            type: String,
            required: false,
        },
        imageIsRightSide: {
            type: Boolean,
            required: false,
            default: false,
        },
    },
    computed: {
        titleData() {
            return {
                imageTextTitle: this.$props.imageTextTitle,
            };
        },
        descriptionData() {
            return {
                imageTextDescription: this.$props.imageTextDescription,
            };
        },
        imageData() {
            return {
                fileReference: this.$props.fileReference,
                imageIsRightSide: this.$props.imageIsRightSide,
            };
        },
    },
};
</script>

<style lang="scss" scoped>
@import "./v-style/article_image_text_default";
@import "./v-style/article_image_text_media";
</style>