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
</script>

<style lang="scss" scoped>
@import "./slick-dots_default";
@import "./slick-dots_media";
</style>
