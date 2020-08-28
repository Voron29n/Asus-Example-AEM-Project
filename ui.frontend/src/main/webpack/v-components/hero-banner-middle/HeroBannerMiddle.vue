<template>
    <div class="af-banner-middle">
        <div class="banner-middle-block">
            <div class="banner-middle-inner">
                <v-hero-middle
                    :hero-middle-data="heroMiddleData"
                ></v-hero-middle>
            </div>
        </div>
    </div>
</template>

<script>
import HeroBannerMiddle_HeroMiddleCmp from "./v-components/HeroMiddle";

export default {
    components: {
        "v-hero-middle": HeroBannerMiddle_HeroMiddleCmp,
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
        heroMiddleData() {
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
<style lang="scss" scoped>
@import "./v-style/banner_middle_default";
@import "./v-style/banner_middle_media";
</style>