<template>
    <div id="article_image-component-vue">
        <VueImage :image-data="imageData"></VueImage>
    </div>
</template>

<script>
export default {
    components: {
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