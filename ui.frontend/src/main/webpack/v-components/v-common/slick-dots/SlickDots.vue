<template>
    <div>
        <ul class="slick-dots">
            <li
                :class="{ 'slick-active': index === activeItemId }"
                v-for="(item, index) in itemsData"
                :key="index"
            >
                <button type="button" @click="slickDot(index)"></button>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    props: {
        itemsData: Array,
        activeItemId: Number,
    },
    methods: {
        slickDot(selectIndex) {
            this.$emit("change-slick-dots", selectIndex);
        },
    },
};

import (/* webpackChunkName: "SlickDots" */ './_slick-dots_default.scss');
</script>
