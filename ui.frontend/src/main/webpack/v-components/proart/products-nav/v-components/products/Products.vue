<template>
        <div class="product_list">
            <div class="product"
            v-for="productItem in productsData.productsNav"
            :key="productItem.title"
            >
                <a
                    class="content-link"
                    :href="productItem.linkTo"
                    :target="productItem.linkUrlTarget"
                ></a>

                <div class="product-img">
                    <figure
                        class="img grace-show"
                        :style="{'background-image': getImage(productItem)}"
                    ></figure>
                </div>

                <div class="product-mask"></div>

                <div class="product-content">
                    <div class="content-title text_bold">{{productItem.title}}</div>
                    <div class="content-hidden">
                        <div class="content-info text_regular">
                            <span v-html="productItem.description"></span>
                        </div>
                    </div>
                </div>

                <div class="product-frame">
                    <div class="frame-top"></div>
                    <div class="frame-right"></div>
                    <div class="frame-bottom"></div>
                    <div class="frame-left"></div>
                </div>
            </div>
        </div>
</template>

<script>
import { adapt } from "@mixin/adaptFromDesktopToMobileVersion";

export default {
    mixins: [adapt],
    props: {
        productsData: Object,
    },
    methods: {
        getImage(el) {
          let style = null;
            switch (this.windowVersion) {
                case "small":
                    style = ("url(" + el.fileReferenceSmall + ")");
                    break;
                case "medium":
                    style = ("url(" + el.fileReferenceMedium + ")");
                    break;
                case "large":
                    style = ("url(" + el.fileReferenceLarge + ")");
                    break;
                default:
                    return;
            }
            return style;
        },
    },
};
</script>

<style lang="scss">
@import "./products_default";
@import "./products_media";
</style>
