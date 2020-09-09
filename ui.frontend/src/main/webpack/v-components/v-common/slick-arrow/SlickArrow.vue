<template>
    <div>
        <div class="l-arrow slick-arrow">
            <button type="button" class="slick-prev" @click="slickNextOrPrev(false)"></button>
        </div>
        <div class="r-arrow slick-arrow">
            <button type="button" class="slick-next" @click="slickNextOrPrev(true)"></button>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        imagesLength: Number,
        activeImageId: Number,
    },
    methods: {
        slickNextOrPrev(isNext) {
            let lastIndex = this.imagesLength - 1;
            let currentIndex = this.activeImageId;
            let selectIndex = null;

            if (isNext) {
                selectIndex = currentIndex === lastIndex ? 0 : currentIndex + 1;
            } else {
                selectIndex = currentIndex === 0 ? lastIndex : currentIndex - 1;
            }

            this.$emit("change-slick-arrow", selectIndex);
        },
    },
};

import (/* webpackChunkName: "SlickArrow" */ './_slick-arrow_default.scss');
import (/* webpackChunkName: "SlickArrow" */ './_slick-arrow_media.scss');
</script>
