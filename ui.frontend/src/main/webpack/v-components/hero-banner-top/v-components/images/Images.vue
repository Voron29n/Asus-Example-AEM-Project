<template>
  <div>
    <section class="af-banner af-top-banner loaded" id="hero-banner-top">
      <ul
        class="top-slider slick-initialized slick-slider"
        :data-activeImageId="activeImageId"
      >
        <div class="slick-list draggable">
          <div class="slick-track" :style="fullWidth" role="listbox">
            <li
              class="slick-slide"
              :class="{
                'slick-current slick-active active-on': index === activeImageId,
                'active-off': index != activeImageId,
              }"
              :style="widthLi"
              :id="[`top_image_li-${index}`]"
              :data-slick-index="[`${index}`]"
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
                        :src="imageItem.fileReference"
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
            :class="{
              'slick-active': index === activeImageId,
              '': index != activeImageId,
            }"
            :id="[`slick-slide-${index}`]"
            :data-slick-dots-index="[`${index}`]"
            v-for="(imageItem, index) in imagesData.heroItems"
            :key="index"
          >
            <button
              type="button"
              data-role="none"
              role="button"
              aria-required="false"
              :tabindex="index"
              @click="slickDot(index)"
            ></button>
          </li>
        </ul>

        <div class="l-arrow slick-arrow">
          <button
            type="button"
            class="slick-prev"
            @click="slickPrev()"
          ></button>
        </div>
        <div class="r-arrow slick-arrow">
          <button
            type="button"
            class="slick-next"
            @click="slickNext()"
          ></button>
        </div>
      </ul>
    </section>
  </div>
</template>

<script>
export default {
  props: {
    imagesData: Object,
  },
  data() {
    return {
      isDesktopVersion: false,
      imagesLength: null,
      activeImageIndex: null,
      activeImageId: null,
      activeItem: null,
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
      //       $('#hero-banner-top ul li').each(function(index, item){
      //          column1RelArray.push($(this).attr('rel'));
      //        });
      // let list = $("#hero-banner-top ul").querySelectorAll('li');

      $("#hero-banner-top .top-slider .slick-slide").each(function(
        index,
        item
      ) {
        if (index === 0) {
          item.style.left = "0px";
        } else {
          // item.style.left = '-' + index * this.widthLi.width + 'px';
          item.style.left = "-" + index * window.innerWidth + "px";
        }
      });
    },

    selectImage(index) {
      this.activeItem = index;
    },
    activeImage(index) {
      this.activeImageId = index;
    },
    imageTimeout() {
      if (!this.pauseSlick) {
        var length = this.imagesLength;
        var next = this.activeImageIndex;

        // $("#hero-banner-top ul li").hide();
        let elem = $("#hero-banner-top .top-slider .slick-slide").eq(
          length - next
        );
        // elem.show();

        let slickIndex = $(elem).data("slick-index");

        this.activeImage(slickIndex);

        if (--this.activeImageIndex) {
          setTimeout(this.imageTimeout, 5000);
        }
        if (this.activeImageIndex === 0) {
          this.activeImageIndex = this.imagesLength;
          setTimeout(this.imageTimeout, 5000);
        }
      } else {
        this.pauseSlick = false;
        setTimeout(this.imageTimeout, 10000);
      }
    },
    imageLength: function() {
      if (this.$props.imagesData.heroItems != null) {
        this.imagesLength = this.$props.imagesData.heroItems.length;
        this.activeImageIndex = this.imagesLength;
      }
    },
    slickPrev: function() {
      this.pauseSlick = true;
      let length = this.imagesLength;
      let curentIndex = this.activeImageId;
      let selectIndex = null;
      if (curentIndex === 0) {
        selectIndex = length - 1;
      } else {
        selectIndex = curentIndex - 1;
      }
      this.activeImage(selectIndex);
    },
    slickNext: function() {
      this.pauseSlick = true;
      let length = this.imagesLength;
      let curentIndex = this.activeImageId;
      let selectIndex = null;
      if (curentIndex === length - 1) {
        selectIndex = 0;
      } else {
        selectIndex = curentIndex + 1;
      }
      this.activeImage(selectIndex);
    },
    slickDot: function(selectIndex) {
      this.pauseSlick = true;
      this.activeImage(selectIndex);
    },
  },
};
</script>

<style lang="scss">
@import "./images_default";
@import "./images_media";
</style>
