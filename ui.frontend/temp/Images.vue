<template>
  <div class="af-banner af-top-banner loaded" id="hero-banner-top">
    <ul class="top-slider slick-initialized slick-slider">
      <div class="slick-list draggable">
        <div class="slick-track" :style="fullWidth">
          <li
            class="slick-slide"
            :class="{
              'slick-current slick-active active-on': index === activeImageId,
              'active-off': index != activeImageId,
            }"
            :style="widthLi"
            :id="[`top_image_li-${index}`]"
            v-for="(imageItem, index) in imagesData.heroItems"
            :key="index"
          >
            <div
              class="banner-block af-top-banner"
              :title="imageItem.descriptionLink"
            >
              <div class="banner-inner">
                <div class="banner-wrap">
                  <a
                    class="af-link-block"
                    :title="imageItem.descriptionLink"
                    :data-link="imageItem.linkTo"
                    :href="imageItem.linkTo"
                    :target="imageItem.linkUrlTarget"
                  >
                    {{ imageItem.descriptionLink }}
                  </a>

                  <div class="banner-img">
                    <img
                      :alt="imageItem.descriptionLink"
                      :src="
                        isDesktopVersion
                          ? imageItem.fileReferenceDesktop
                          : imageItem.fileReferenceMobile
                      "
                    />
                  </div>
                </div>
              </div>
            </div>
          </li>
        </div>
      </div>

      <ul class="slick-dots">
        <li
          :class="{ 'slick-active': index === activeImageId }"
          v-for="(imageItem, index) in imagesData.heroItems"
          :key="index"
        >
          <button type="button" @click="slickDot(index)"></button>
        </li>
      </ul>

      <div class="l-arrow slick-arrow">
        <button
          type="button"
          class="slick-prev"
          @click="slickNextOrPrev(false)"
        ></button>
      </div>
      <div class="r-arrow slick-arrow">
        <button
          type="button"
          class="slick-next"
          @click="slickNextOrPrev(true)"
        ></button>
      </div>
    </ul>
  </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
  mixins: [adapt],
  props: {
    imagesData: Object,
  },
  data() {
    return {
      imagesLength: null,
      activeImageId: null,

      countForCycle: null,

      fullWidth: {
        width: null,
      },
      widthLi: {
        width: null,
      },
      pauseSlick: false,
    };
  },
  mounted() {
    this.imageLength();
    this.updateStyle();
    this.imageTimeout();
  },
  created() {
    window.addEventListener("resize", this.updateStyle);
  },
  methods: {
    activateImage(index) {
      this.activeImageId = index;
    },
    updateStyle() {
      this.updateFullWidth();
      this.updateStyleWidthLi();
      this.updateStyleLeftLi();
    },
    updateFullWidth() {
      this.fullWidth.width = this.imagesLength * window.innerWidth + "px";
    },
    updateStyleWidthLi() {
      this.widthLi.width = window.innerWidth + "px";
    },
    updateStyleLeftLi() {
      let elements = this.$el.querySelectorAll(".top-slider .slick-slide");
      elements.forEach(function(item, index) {
        if (index === 0) {
          item.style.left = "0px";
        } else {
          item.style.left = "-" + index * window.innerWidth + "px";
        }
      });
    },

    imageTimeout() {
      if (this.pauseSlick) {
        this.pauseSlick = false;
        setTimeout(this.imageTimeout, 10000);
      } else {
        this.activateImage(this.imagesLength - this.countForCycle);
        this.countForCycle--;
        if (this.countForCycle === 0) this.countForCycle = this.imagesLength;
        setTimeout(this.imageTimeout, 5000);
      }
    },

    imageLength: function() {
      if (this.$props.imagesData.heroItems != null) {
        this.imagesLength = this.$props.imagesData.heroItems.length;
        this.countForCycle = this.imagesLength;
      }
    },

    slickNextOrPrev(isNext) {
      this.pauseSlick = true;

      let lastIndex = this.imagesLength - 1;
      let curentIndex = this.activeImageId;
      let selectIndex = null;

      if (isNext) {
        selectIndex = curentIndex === lastIndex ? 0 : curentIndex + 1;
      } else {
        selectIndex = curentIndex === 0 ? lastIndex : curentIndex - 1;
      }
      this.activateImage(selectIndex);
    },

    slickDot: function(selectIndex) {
      this.pauseSlick = true;
      this.activateImage(selectIndex);
    },
  },
};
</script>

<style lang="scss">
@import "./images_default";
@import "./images_media";
</style>
