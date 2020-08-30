<template>
    <div>Hero Banner Middle List</div>
</template>

<script>
export default {
    props: {
        heroBannerMiddleListItems: {
            type: String,
            required: true,
        }
    },
};
</script>
<style lang="scss" scoped>
@import "./v-style/banner_middle_list_default";
@import "./v-style/banner_middle_list_media";
</style>