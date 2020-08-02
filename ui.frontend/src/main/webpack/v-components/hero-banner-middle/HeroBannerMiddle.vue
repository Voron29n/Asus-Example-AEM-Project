<template>
    <div class="af-banner">
        <div class="banner-block">
            <div class="banner-inner">
                <v-image
                    :image-data="imageData"
                ></v-image>
            </div>
        </div>
    </div>
</template>

<script>
import ImageComponent from "./v-components/Image";

export default {
    components: {
        "v-image": ImageComponent,
    },
    props: {
        linkTo: {
            type: String,
            required: false,
        },
        linkUrlTarget: {
            type: String,
            required: false,
        },
        fileReferenceMobile: {
            type: String,
            required: false,
        },
        fileReferenceDesktope: {
            type: String,
            required: false,
        },
    },
    computed: {
        imageData() {
            return {
                linkTo: this.$props.linkTo,
                linkUrlTarget: this.$props.linkUrlTarget,
                fileReferenceMobile: this.$props.fileReferenceMobile,
                fileReferenceDesktope: this.$props.fileReferenceDesktope,
            };
        },
    },
};
</script>
<style lang="scss">
@import "./v-style/banner_default";
@import "./v-style/banner_media";
</style>