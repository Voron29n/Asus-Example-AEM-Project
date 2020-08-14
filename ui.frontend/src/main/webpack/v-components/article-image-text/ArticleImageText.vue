<template>
<div id="article_image-text-component-vue">
    <v-title :title-data="titleData"></v-title>
    <div class="cmp_article_image_text-block">
        <v-image :image-data="imageData"></v-image>
        <v-description :description-data="descriptionData"></v-description> 
    </div>
</div>
</template>

<script>
import TitleData from './v-components/title/Title'
import DescriptionData from './v-components/description/Description'
import ImageData from './v-components/image/Image'

export default {
    components: {
        "v-title": TitleData,
        "v-description": DescriptionData,
        "v-image": ImageData,
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
            default: false
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