<template>
    <div class="banner-wrap">
        <a class="af-link-block" :href="imageData.linkTo" :target="imageData.linkUrlTarget"></a>
        <div class="banner-img">
            <img :src="imageSrc" />
        </div>
    </div>
</template>

<script>
import {adapt} from "@mixin/adaptFromDesktopToMobileVersion"

import constant from "@util/v-constant";

export default {
    mixins: [adapt],
    data() {
        return {
            imageSrc: "",
            witchForMobileVersion:
                constant.heroBannerMiddle.widthForMobileVersion,
        };
    },
    props: {
        imageData: Object,
    },
    methods: {
        adaptToWindow() {
            this.$data.imageSrc =
                this.isDesktopVersion()
                    ? this.$props.imageData.fileReferenceDesktop
                    : this.$props.imageData.fileReferenceMobile;
        },
    },
};
</script>

<style lang="scss">
@import "./image_default";
</style>