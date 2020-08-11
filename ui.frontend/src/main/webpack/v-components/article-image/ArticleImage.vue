<template>
<div id="article_image-component-vue">
    <v-image :image-data="imageData"></v-image>
</div>
</template>

<script>
import ImageData from './v-components/image/Image'

export default {
    components: {
        "v-image": ImageData,
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