<template>
    <div>
        <div class="categories_list">
            <div class="category"
            v-for="categoryItem in categoriesData.categoriesNav"
            :key="categoryItem.title"
            >
                <a
                    class="content-link"
                    :href="categoryItem.linkTo"
                    :target="categoryItem.linkUrlTarget"
                ></a>

                <div class="category-img">
                    <figure
                        class="img grace-show"
                        :style="{'background-image': getImage(categoryItem)}"
                    ></figure>
                </div>

            </div>
        </div>
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
        categoriesData: Object,
    },
    methods: {
        getImage(el) {
          let style = null;
            switch (this.windowVersion) {
                case "small":
                    style = ("url(" + el.fileReferenceMobile + ")");
                    break;
                case "large":
                    style = ("url(" + el.fileReferenceDesktop + ")");
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
@import "./categories_default";
@import "./categories_media";
</style>
