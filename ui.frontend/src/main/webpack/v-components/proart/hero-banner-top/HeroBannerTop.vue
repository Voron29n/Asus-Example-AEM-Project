<template>
<div id="proart__hero_banner_top">
  <div class="row">
    <div class="col l12 m12 s12 always__on__top">
        <div class="kv_banner_carousel">
            <div class="component_container" id="kv_banner">
                <div class="carousel-list stopCarousel">
                    <div class="carousel-item item-1">
                        <v-title :title-data="titleData"></v-title> 
                        <v-image :image-data="imageData"></v-image>
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
    fileReferenceDesktop: {
      type: String,
      required: false,
    },
    fileReferenceMobile: {
      type: String,
      required: false,
    },
  },
  computed: {
    imageData() {
      return {
        fileReferenceMobile: this.$props.fileReferenceMobile,
        fileReferenceDesktop: this.$props.fileReferenceDesktop,
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
