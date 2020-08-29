<template>
    <div class="banner-middle-image-wrap">
        <a class="af-banner-middle-link-block" :href="heroMiddleData.linkTo" :target="heroMiddleData.linkUrlTarget"></a>
        <div class="banner-middle-img">
            <img :src="imageSrc" />
        </div>
    </div>
</template>

<script>
import {adapt} from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    data() {
        return {
            imageSrc: "",
        };
    },
    props: {
        heroMiddleData: Object,
    },
    methods: {
        adaptToWindow() {
            this.$data.imageSrc =
                this.isDesktopVersionMeth()
                    ? this.$props.heroMiddleData.fileReferenceDesktop
                    : this.$props.heroMiddleData.fileReferenceMobile;
        },
    },
};
</script>

<style lang="scss">
@import "./hero_middle_default";
</style>