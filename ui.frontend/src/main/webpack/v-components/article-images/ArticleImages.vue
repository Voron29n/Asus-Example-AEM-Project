<template>
<div id="article_image-component-vue">
        <v-title :title-data="titleData"></v-title>
        <v-images :images-data="imagesData"></v-images>
</div>
</template>

<script>
import TitleData from './v-components/title/Title'
import ImagesData from './v-components/images/Images'

export default {
    components: {
        "v-title": TitleData,
        "v-images": ImagesData,
    },
    props: {
        imagesTitle: {
            type: String,
            required: false,
        },
        images: {
            type: String,
            required: false,
            default: ""
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