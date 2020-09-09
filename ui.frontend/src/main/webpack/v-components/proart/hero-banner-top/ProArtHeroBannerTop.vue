<template>
    <div id="proart__hero_banner_top">
        <div class="row">
            <div class="col l12 m12 s12 always__on__top">
                <div class="kv_banner_carousel">
                    <div class="component_container" id="kv_banner">
                        <div class="carousel-list stopCarousel">
                            <div class="carousel-item item-1">
                                <VueImage :image-data="imageData"></VueImage>
                                <VueTitle :title-data="titleData"></VueTitle>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    components: {
        VueImage: () =>
            import(
                /* webpackChunkName: "ProArtHeroBannerTop" */ "./v-components/image/Image"
            ),
        VueTitle: () =>
            import(
                /* webpackChunkName: "ProArtHeroBannerTop" */ "./v-components/title/Title"
            ),
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

import (/* webpackChunkName: "ProArtHeroBannerTop" */ './v-style/_hero_banner_top_default.scss');
import (/* webpackChunkName: "ProArtHeroBannerTop" */ './v-style/_hero_banner_top_media.scss');
</script>
