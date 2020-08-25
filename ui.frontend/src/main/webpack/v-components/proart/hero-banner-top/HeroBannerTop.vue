<template>
    <div id="proart__hero_banner_top">
        <div class="row">
            <div class="col l12 m12 s12 always__on__top">
                <div class="kv_banner_carousel">
                    <div class="component_container" id="kv_banner">
                        <div class="carousel-list stopCarousel">
                            <div class="carousel-item item-1">
                                <v-image :image-data="imageData"></v-image>
                                <v-title :title-data="titleData"></v-title>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import TitleData from "./v-components/title/Title";
import ImageData from "./v-components/image/Image";

export default {
    components: {
        "v-title": TitleData,
        "v-image": ImageData,
    },
    props: {
        heroTitle: {
            type: String,
            required: false,
        },
        fileReferenceSmall: {
            type: String,
            required: false,
        },
        fileReferenceMedium: {
            type: String,
            required: false,
        },
        fileReferenceLarge: {
            type: String,
            required: false,
        },
    },
    computed: {
        imageData() {
            return {
                fileReferenceSmall: this.$props.fileReferenceSmall,
                fileReferenceMedium: this.$props.fileReferenceMedium,
                fileReferenceLarge: this.$props.fileReferenceLarge,
            };
        },
        titleData() {
            return {
                heroTitle: this.$props.heroTitle,
            };
        },
    },
};
</script>
<style lang="scss">
@import "./v-style/hero_banner_top_default";
@import "./v-style/hero_banner_top_media";
</style>
