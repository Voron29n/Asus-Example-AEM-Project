<template>
    <div class="af-banner-middle">
        <div class="banner-middle-block">
            <div class="banner-middle-inner">
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
        fileReferenceDesktop: {
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
                fileReferenceDesktop: this.$props.fileReferenceDesktop,
            };
        },
    },
};
</script>
<style lang="scss">
@import "./v-style/banner_middle_default";
@import "./v-style/banner_middle_media";
</style>