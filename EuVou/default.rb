
virtual_box_link = "http://download.virtualbox.org/virtualbox/5.1.6/VirtualBox-5.1.6-110634-Linux_amd64.run"

# Create VirtualBox installation folder
directory '/home/android/virtualbox' do
    owner 'android'
    mode '0755'
    action :create
end

# Download VirtualBox
remote_file '/home/android/virtualbox/virtualbox.run' do
    source virtual_box_link
    owner 'android'
    mode '0755'
    action :create
end

# Install VirtualBox
execute "Installing Virtual Box" do
    command "sudo chmod +x virtualbox.run"
    command "sudo ./virtualbox.run"
    user "android"
    action :run
end
