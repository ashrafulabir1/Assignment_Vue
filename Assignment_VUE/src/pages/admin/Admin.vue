<template>
<Nav/>
<div className="wrraper">
<div className="left-content">
<SideBar/>
</div>
<div className="right-content">
<router-view/>
</div>
</div>
</template>

<script>
import Nav from '@/components/Nav'
import SideBar from '@/components/SideBar'

export default {
name: 'Admin',
components: {Nav, SideBar}
}
</script>

<style>
</style>