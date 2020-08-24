<template>
    <div class="proart__hero_banner_top__image item-img">
        <!-- <img :src="imageSrc" /> -->
        <figure class="img"
        :style="{'background-image': imageSrcStyle}"
        ></figure>
    </div>
</template>

<script>
import {adapt} from "@mixin/adaptFromDesktopToMobileVersion";

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
            this.$data.imageSrcStyle =
                this.isDesktopVersionMeth()
                    ? 'url(' + this.$props.imageData.fileReferenceDesktop + ')'
                    : 'url(' + this.$props.imageData.fileReferenceMobile + ')';
        },
    },
};
</script>

<style lang="scss">
@import "./image_default";
@import "./image_media";
</style>