<template>
    <div class="banner-middle-image-wrap">
        <a class="af-link-block" :href="imageData.linkTo" :target="imageData.linkUrlTarget"></a>
        <div class="banner-img">
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
        imageData: Object,
    },
    methods: {
        adaptToWindow() {
            this.$data.imageSrc =
                this.isDesktopVersionMeth()
                    ? this.$props.imageData.fileReferenceDesktop
                    : this.$props.imageData.fileReferenceMobile;
        },
    },
};
</script>

<style lang="scss">
@import "./hero_middle_default";
</style>