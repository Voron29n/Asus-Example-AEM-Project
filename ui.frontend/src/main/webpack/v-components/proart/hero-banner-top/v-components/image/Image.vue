<template>
    <div class="proart__hero_banner_top__image item-img">
        <figure class="img" :style="{'background-image': imageSrcStyle}"></figure>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    data() {
        return {
            imageSrcStyle: null,
        };
    },
    props: {
        imageData: Object,
    },
    methods: {
        adaptToWindow() {
            switch (this.getWindowVersion()) {
                case "small":
                    this.$data.imageSrcStyle =
                        "url(" + this.$props.imageData.fileReferenceSmall + ")";
                    break;
                case "medium":
                    this.$data.imageSrcStyle =
                        "url(" +
                        this.$props.imageData.fileReferenceMedium +
                        ")";
                    break;
                case "large":
                    this.$data.imageSrcStyle =
                        "url(" + this.$props.imageData.fileReferenceLarge + ")";
                    break;
                default:
                    this.$data.imageSrcStyle =
                        "url(" + this.$props.imageData.fileReferenceLarge + ")";
            }
        },
    },
};
</script>

<style lang="scss">
@import "./image_default";
@import "./image_media";
</style>