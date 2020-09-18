<template>
    <div class="img_wall_List">
        <div class="imgWall-box frame_ani frame_ani-h"
            v-for="categoryItem in categoriesData.categoriesNav"
            :key="categoryItem.title"
            >
            <div class="imgWall-img">
                <figure
                    class="img grace-show"
                    :style="{'background-image': getImage(categoryItem)}"
                ></figure>
            </div>
            <div class="imgWall-txt text_regular">
                <span class="text__no__wrap">{{categoryItem.title}}</span>
            </div>

            <div class="frame_ani-frame imgWall-frame category-frame">
                <div class="frame-top"></div>
                <div class="frame-right"></div>
                <div class="frame-bottom"></div>
                <div class="frame-left"></div>
            </div>

            <a
                class="moreLink"
                :href="categoryItem.linkTo"
                :target="categoryItem.linkUrlTarget"
            ></a>
        </div>
    </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        categoriesData: Object,
    },
    methods: {
        getImage(el) {
          let style = null;
            switch (this.getWindowVersion()) {
                case "small":
                    style = ("url(" + el.fileReferenceDesktop + ")");
                    break;
                case "large":
                    style = ("url(" + el.fileReferenceDesktop + ")");
                    break;
                default:
                     style = ("url(" + el.fileReferenceDesktop + ")");
                    break;
            }
            return style;
        },
    },
};
</script>

<style lang="scss">
@import "./categories_default";
@import "./categories_media";
</style>
